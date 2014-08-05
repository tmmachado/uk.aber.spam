// @SOURCE:/Users/TarcioMac/Development/PlayProjects/uk.aber.spam/conf/routes
// @HASH:2809cc1156986d648d22b94273f7f32daee5eb59
// @DATE:Tue Aug 05 15:55:26 BST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
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
// @LINE:10
class ReverseYearTutorController {
    

// @LINE:10
def getJSON(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/yt")
}
                        

// @LINE:12
def updateOutcome(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ytList")
}
                        
    
}
                          

// @LINE:14
// @LINE:11
class ReverseDotController {
    

// @LINE:11
def getJSON(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/dot")
}
                        

// @LINE:14
def updateOutcome(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "dotList")
}
                        
    
}
                          

// @LINE:15
// @LINE:13
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def studentReport(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "studentReport")
}
                        

// @LINE:13
def ytList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ytList")
}
                        

// @LINE:15
def dotList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "dotList")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        
    
}
                          
}
                  


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:18
class ReverseAssets {
    

// @LINE:18
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
                        

// @LINE:12
def updateOutcome : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YearTutorController.updateOutcome",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ytList"})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:11
class ReverseDotController {
    

// @LINE:11
def getJSON : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DotController.getJSON",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/dot"})
      }
   """
)
                        

// @LINE:14
def updateOutcome : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DotController.updateOutcome",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dotList"})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:13
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
                        

// @LINE:13
def ytList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ytList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ytList"})
      }
   """
)
                        

// @LINE:15
def dotList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dotList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dotList"})
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
        


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:18
class ReverseAssets {
    

// @LINE:18
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
// @LINE:10
class ReverseYearTutorController {
    

// @LINE:10
def getJSON(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YearTutorController.getJSON(), HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "getJSON", Seq(), "GET", """""", _prefix + """json/yt""")
)
                      

// @LINE:12
def updateOutcome(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YearTutorController.updateOutcome(), HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "updateOutcome", Seq(), "POST", """""", _prefix + """ytList""")
)
                      
    
}
                          

// @LINE:14
// @LINE:11
class ReverseDotController {
    

// @LINE:11
def getJSON(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DotController.getJSON(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DotController", "getJSON", Seq(), "GET", """""", _prefix + """json/dot""")
)
                      

// @LINE:14
def updateOutcome(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DotController.updateOutcome(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DotController", "updateOutcome", Seq(), "POST", """""", _prefix + """dotList""")
)
                      
    
}
                          

// @LINE:15
// @LINE:13
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def studentReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.studentReport(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "studentReport", Seq(), "GET", """""", _prefix + """studentReport""")
)
                      

// @LINE:13
def ytList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ytList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ytList", Seq(), "GET", """""", _prefix + """ytList""")
)
                      

// @LINE:15
def dotList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dotList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dotList", Seq(), "GET", """""", _prefix + """dotList""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    