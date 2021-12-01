FROM livingobjects/jre8
LABEL maintainer axue
RUN mkdir -p /saas-gateway/saas-gateway-app/
COPY ./saas-gateway/saas-gateway-app/target/saas-gateway-app-1.0.0.jar /saas-gateway/saas-gateway-app/
WORKDIR /saas-gateway/saas-gateway-app/
EXPOSE 8301
EXPOSE 18301
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-gateway-app-1.0.0.jar" ]