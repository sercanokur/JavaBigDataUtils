# JavaBigDataUtils


Setting up a Hadoop Cluster Using Docker

To install Hadoop in a Docker container, we need a Hadoop Docker image. 
To generate the image, we will use the Big Data Europe repository. 
If Git is installed in your system, run the following command,
if not, simply download the compressed zip file to your computer:

$ git clone git@github.com:big-data-europe/docker-hadoop.git

Once we have the docker-hadoop folder on your local machine, we will need to edit the docker-compose.yml file to enable some listening ports and change where Docker-compose pulls the images from in case we have the images locally already (Docker will attempt to download files and build the images the first time we run, but on subsequent times, we would love to use the already existing images on disk instead of rebuilding everything from scratch again).


To deploy a Hadoop cluster, use this command:

$ docker-compose up -d
