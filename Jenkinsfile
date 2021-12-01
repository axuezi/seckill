// 公共
env.registry = "harbor.space.com"  // 镜像仓库地址

// 项目
env.imageTag = new Date().format('yyyyMMddHHmm')
env.project = "iot"  // 镜像仓库
env.app_name = params.module  // 镜像
env.image_name = "${registry}/${project}/"
def git_address = "http://172.16.163.22/space-iot/space-iot.git"   // gitlab仓库
def chart_address = "http://gitlab.space.com/devops/chart.git"  // char仓库
env.devops_path = "./devops/deploy"        // dockerfile路径

// 认证
env.secret_name = "harbor"    //保存在k8s上的harbor secret
def docker_registry_auth = "15ddb84c-7be1-4c24-b9a4-55f8ce141824"  // 连接docker镜像仓库的凭据
def git_auth = "ac17e789-173f-4858-a916-9b6fe250c3e6"          // 连接git仓库的凭据
def k8s_auth = "6c8fa9ab-8c80-478e-8bef-705786b54625"   // 连接k8s的凭据

//参数
env.Namespace = params.Namespace

//钉钉
env.BRANCH = params.Branch
env.current_time = new Date().format('yyyy-MM-dd HH:mm')
env.module = params.module
// def DingTalk = "9feca95c-b61e-49dc-ab1c-0e5285a7916c"


pipeline {
  agent {
    kubernetes {
        label "jenkins-slave"
        yaml """
kind: Pod
metadata:
  name: jenkins-slave
spec:
  containers:
  - name: jnlp
    image: "${registry}/investment/jenkins-slave"
    imagePullPolicy: Always
    volumeMounts:
      - name: docker-cmd
        mountPath: /usr/local/bin/docker
      - name: docker-sock
        mountPath: /var/run/docker.sock
      - name: maven-cache
        mountPath: /root/.m2
  volumes:
    - name: docker-cmd
      hostPath:
        path: /usr/local/bin/docker
    - name: docker-sock
      hostPath:
        path: /var/run/docker.sock
    - name: maven-cache
      hostPath:
        path: /tmp/m2
"""
        }
    }
    parameters {
        // 选择部署的分支
        gitParameter branch: '', branchFilter: '.*', defaultValue: 'master', description: '选择发布的分支', name: 'Branch', quickFilterEnabled: false, selectedValue: 'NONE', sortMode: 'NONE', tagFilter: '*', type: 'PT_BRANCH'
        choice (choices: ['fat','sit'], description: '命名空间', name: 'Namespace')  // 选择部署到的命名空间
        extendedChoice description: '', multiSelectDelimiter: ',', name: 'module', quoteValue: false,
        saveJSONParameterToFile: false, type: 'PT_CHECKBOX', value: 'auth-user,gateway-app,gateway-web,solution-light,solution-activity,solution-order,solution-product,solution-stock', visibleItemCount: 25
    }
    stages {
        stage('拉取代码'){
            steps {
                checkout([$class: 'GitSCM',
                branches: [[name: "${params.Branch}"]],
                doGenerateSubmoduleConfigurations: false,
                extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]
                ])
            }
        }
        stage('代码质量检查') {

        }
        stage('代码编译'){
           steps {
             sh '''
                for  microservice  in `echo ${module}|awk -F "," '{for(i=1;i<=NF;++i) print $i}'`;do
                    mvn clean install  -am -amd -P spaas -pl `find ./ -name saas-${microservice} | grep -v devops` -Dmaven.test.skip=true
                done
                '''
          }
        }

        stage('构建镜像'){
           steps {
                withCredentials([usernamePassword(credentialsId: "${docker_registry_auth}", passwordVariable: 'password', usernameVariable: 'username')]) {
                sh '''
                docker login -u ${username} -p ${password} ${registry}
                for  microservice  in `echo ${module}|awk -F "," '{for(i=1;i<=NF;++i) print $i}'`;do
                     echo ${microservice}
                     cp -f ${devops_path}/${microservice}/Dockerfile .
                     ls Dockerfile
                     docker build -t ${image_name}${microservice}:${imageTag} .
                     docker push ${image_name}${microservice}:${imageTag}
                done
                '''
                }
           }
        }
        stage('部署到K8S平台'){
          steps {
                checkout([$class: 'GitSCM',
                branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${chart_address}"]]
                ])          
              configFileProvider([configFile(fileId: "${k8s_auth}", targetLocation: "admin.kubeconfig")]){
                sh '''
                for  microservice  in `echo ${module}|awk -F "," '{for(i=1;i<=NF;++i) print $i}'`;do
                     helm -n ${Namespace} upgrade ${microservice} ${project}/${microservice}/ --install -f ${project}/${microservice}/${Namespace}-values.yaml  -f ${project}/base-value/values-${Namespace}.yaml  --set-string image.tag=${imageTag} --kubeconfig=admin.kubeconfig
                done
                '''
              }
          }
        }
    }
    //构建成功通知
    post {
        success {

         }
        //构建失败通知
        failure {

        }
    }
}
