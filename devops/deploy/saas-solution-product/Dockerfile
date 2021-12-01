FROM livingobjects/jre8
LABEL maintainer axue
RUN mkdir -p /saas-solution/saas-solution-product/
COPY ./saas-solution/saas-iot-product/target/saas-iot-product-1.0.0.jar /saas-solution/saas-solution-product/
WORKDIR /saas-solution/saas-solution-product/
EXPOSE 8103
EXPOSE 18103
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-iot-product-1.0.0.jar" ]