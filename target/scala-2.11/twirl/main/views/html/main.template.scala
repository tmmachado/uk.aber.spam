
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(message: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css")),format.raw/*8.94*/("""'>
        <link rel="shortcut icon" type="image/png" href='"""),_display_(/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png")),format.raw/*9.97*/("""'>
        <link rel="stylesheet" media="screen"
        	href='"""),_display_(/*11.17*/routes/*11.23*/.Assets.at("stylesheets/jquery-ui-themes-1.11.0/themes/smoothness/jquery-ui.min.css")),format.raw/*11.108*/("""'>
        <script src='"""),_display_(/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.js")),format.raw/*12.64*/("""' type="text/javascript"></script>
        <script src='"""),_display_(/*13.23*/routes/*13.29*/.Assets.at("javascripts/globalize.js")),format.raw/*13.67*/("""' type="text/javascript"></script>
        <script src='"""),_display_(/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery-ui-1.11.0/jquery-ui.min.js")),format.raw/*14.88*/("""' type="text/javascript"></script>
        <script src='"""),_display_(/*15.23*/routes/*15.29*/.Assets.at("javascripts/main.js")),format.raw/*15.62*/("""' type="text/javascript"></script>
    </head>
    <body>
    	<div id="feedback">"""),_display_(/*18.26*/message),format.raw/*18.33*/("""</div>
        """),_display_(/*19.10*/content),format.raw/*19.17*/("""
    """),format.raw/*20.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,message:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(message)(content)

  def f:((String) => (String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (message) => (content) => apply(title)(message)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jul 22 17:34:51 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/main.scala.html
                  HASH: 5fba043ac3f0f94bfb2fb3acb854a4e298aaeedb
                  MATRIX: 734->1|869->48|897->50|974->101|999->106|1087->168|1101->174|1155->208|1242->269|1256->275|1308->307|1400->372|1415->378|1522->463|1574->488|1589->494|1645->529|1729->586|1744->592|1803->630|1887->687|1902->693|1982->752|2066->809|2081->815|2135->848|2245->931|2273->938|2316->954|2344->961|2376->966
                  LINES: 26->1|29->1|31->3|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|47->19|47->19|48->20
                  -- GENERATED --
              */
          