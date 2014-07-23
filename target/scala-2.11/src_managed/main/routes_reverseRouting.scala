// @SOURCE:/Users/TarcioMac/Development/PlayProjects/uk.aber.spam/conf/routes
// @HASH:705ee453816e7ffb130cfd210263c3d966e57628
// @DATE:Thu Jul 17 15:26:03 BST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
// @LINE:10
class ReverseYearTutorController {
    

// @LINE:10
def getJSON(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/yt")
}
                        

// @LINE:11
def updateOutcome(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ytList")
}
                        
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        
    
}
                          

// @LINE:9
// @LINE:7
class ReverseAdminController {
    

// @LINE:7
def arrangeMeeting(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "studentReport")
}
                        

// @LINE:9
def getJSON(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/admin")
}
                        
    
}
                          

// @LINE:12
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def studentReport(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "studentReport")
}
                        

// @LINE:12
def ytList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ytList")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        
    
}
                          
}
                  


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
// @LINE:10
class ReverseYearTutorController {
    

// @LINE:10
def getJSON : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YearTutorController.getJSON",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/yt"})
      }
   """
)
                        

// @LINE:11
def updateOutcome : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YearTutorController.updateOutcome",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ytList"})
      }
   """
)
                        
    
}
              

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:7
class ReverseAdminController {
    

// @LINE:7
def arrangeMeeting : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.arrangeMeeting",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "studentReport"})
      }
   """
)
                        

// @LINE:9
def getJSON : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.getJSON",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/admin"})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def studentReport : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.studentReport",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "studentReport"})
      }
   """
)
                        

// @LINE:12
def ytList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ytList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ytList"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
// @LINE:10
class ReverseYearTutorController {
    

// @LINE:10
def getJSON(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YearTutorController.getJSON(), HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "getJSON", Seq(), "GET", """""", _prefix + """json/yt""")
)
                      

// @LINE:11
def updateOutcome(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YearTutorController.updateOutcome(), HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "updateOutcome", Seq(), "POST", """""", _prefix + """ytList""")
)
                      
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:7
class ReverseAdminController {
    

// @LINE:7
def arrangeMeeting(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.arrangeMeeting(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AdminController", "arrangeMeeting", Seq(), "POST", """""", _prefix + """studentReport""")
)
                      

// @LINE:9
def getJSON(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.getJSON(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AdminController", "getJSON", Seq(), "GET", """""", _prefix + """json/admin""")
)
                      
    
}
                          

// @LINE:12
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def studentReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.studentReport(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "studentReport", Seq(), "GET", """""", _prefix + """studentReport""")
)
                      

// @LINE:12
def ytList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ytList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ytList", Seq(), "GET", """""", _prefix + """ytList""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    