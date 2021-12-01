FROM livingobjects/jre8
LABEL maintainer axue
RUN mkdir -p /saas-solution/saas-solution-order/
COPY ./saas-solution/saas-iot-order/target/saas-iot-order-1.0.0.jar /saas-solution/saas-solution-order/
WORKDIR /saas-solution/saas-solution-order/
EXPOSE 8102
EXPOSE 18102
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-iot-order-1.0.0.jar" ]