
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
object student_report extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Student report")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""

    """),format.raw/*5.5*/("""<table id="student_report">
    	<thead>
    		<th>UID</th>
    		<th>NAME</th>
    		<th>REFERENCE</th>
    		<th>YEAR</th>
    		<th>STAGE OF PROCESS</th>
    		<th>SESSIONS FOR PERIOD</th>
    		<th>OVERALL ATTENDANCE</th>
    	</thead>
    	<tbody>
    	</tbody>
    </table>

""")))}),format.raw/*19.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jun 24 11:49:39 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/student_report.scala.html
                  HASH: 622a2492ca4fe7f465cee676628c597f8579dba5
                  MATRIX: 732->1|837->18|865->21|895->43|934->45|966->51|1278->333
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|47->19
                  -- GENERATED --
              */
          