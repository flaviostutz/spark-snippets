FROM flaviostutz/spark-scala-jupyter:1.0.1

ADD /app /app
WORKDIR /app

#warmup
ADD /app/project/assembly.sbt /app/project/
ADD /app/build.sbt /app/
RUN sbt assembly

#compile
ADD /app/src /app/src
RUN sbt assembly && \
    cp /app/target/scala-2.11/app.jar /app/app.jar && \
    cp /app/target/scala-2.11/app.jar /spark/jars/app.jar && \
    rm -rf /app/target

# RUN sbt package && \
#     mv /app/target/scala-2.11/app_2.11-1.0.jar /app/app.jar && \
#     rm -rf /app/target

ADD notebooks /
ADD startup.sh /

VOLUME /notebooks

EXPOSE 8888

CMD [ "/startup.sh" ]

