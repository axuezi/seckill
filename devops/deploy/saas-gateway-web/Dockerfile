FROM livingobjects/jre8
LABEL maintainer axue
RUN mkdir -p /saas-gateway/saas-gateway-web/
COPY ./saas-gateway/saas-gateway-web/target/saas-gateway-web-1.0.0.jar /saas-gateway/saas-gateway-web/
WORKDIR /saas-gateway/saas-gateway-web/
EXPOSE 8302
EXPOSE 18302
CMD [ "sh", "-ec", "exec java ${JAVA_OPTS} -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -jar saas-gateway-web-1.0.0.jar" ]