
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("SPAM")/*3.14*/ {_display_(Seq[Any](format.raw/*3.16*/("""

    """),format.raw/*5.5*/("""<p>Welcome, this is the first step to the SPAM application!</p>
    <p>Email plugin configured.</p>
    <p>Oracle database configured.</p>
    <p>Integrated with GitHub.</p>

""")))}),format.raw/*10.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jun 21 18:06:30 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/index.scala.html
                  HASH: d5de8e712088046e1418ca6e839196b0b63b4e3e
                  MATRIX: 723->1|828->18|856->21|876->33|915->35|947->41|1153->217
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|38->10
                  -- GENERATED --
              */
          