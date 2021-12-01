FROM livingobjects/jre8
LABEL maintainer axue
RUN mkdir -p /saas-solution/saas-solution-activity/
COPY ./saas-solution/saas-iot-activity/target/saas-iot-activity-1.0.0.jar /saas-solution/saas-solution-activity/
WORKDIR /saas-solution/saas-solution-activity/
EXPOSE 8200
EXPOSE 18200
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-iot-activity-1.0.0.jar" ]