# RESTApisJersey

in web.xml file param name jersey.config.server.provider.packages takes a base package value(all resource classes will be kept
under this base package only) and a url-pattern. JaxRS lands you to that base package+UrlPattern For example consider the 
following url
localhost:8080/projectName/someUrlPattern

in this project urlPattern is webapi so complete url will be BaseUrl+SomeUrlPattern = localhost:8080/RESTApisJersey/webapi

Now if we have 3 classes under resource package (base package) and Path value for them(set on the class itself) is  
1. "/message" 2. "/profiles"  3. "/someotherresource" respectively 
then for first class we can call all the methods using localhost:8080/RESTApisJersey/webapi/messages url
different methods will be called on the basis of GET, POST, PUT or DELETE JaxRS notation

@Path("/path") => used for url path
@Produces(MediaType), @Consumes(MediaType) Used to denote consumption and production type
@PathParam("paramName") Used for passing parameters
@MatrixParam("paramName") Used for passing parameters
@HeaderParam("headerParamName") used for passing custom headers
@CookieParam("cookieName")
@FormParam("formkeyName")