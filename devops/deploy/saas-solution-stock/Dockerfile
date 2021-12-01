FROM livingobjects/jre8
LABEL maintainer = axue
RUN mkdir -p /saas-solution/saas-solution-stock/
COPY ./saas-solution/saas-iot-stock/target/saas-iot-stock-1.0.0.jar /saas-solution/saas-solution-stock/
WORKDIR /saas-solution/saas-solution-stock/
EXPOSE 8104
EXPOSE 18104
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-iot-stock-1.0.0.jar" ]