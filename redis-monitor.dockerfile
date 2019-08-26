# sets the Base Image (ruby) for subsequent instructions - tag: 2.4
FROM ruby:2.4

# executes installation of redis-stat using gem in a new layer on top of the current image and commit the results
RUN gem install redis-stat

# creates a mount point in /data 
VOLUME ["/data"]

# listens on the specified network port at runtime
EXPOSE 63790