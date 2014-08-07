
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
object summary extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Meetings summary")/*3.26*/(message)/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_summary.js")),format.raw/*4.65*/("""" type="text/javascript"></script>
	<div class="main">
		<!-- <form id="form_search" class="search" action="" method="post"> -->
			<fieldset class="search">
				<label for="stud_uid">Student UID</label>
				<input type="text" name="stud_uid" id="stud_uid" />

				<label for="date">Academic year</label>
				<input type="text" name="academic_year" id="academic_year" />

				<input type="submit" id="btn_search" value="Search" />
			</fieldset>
		<!-- </form> -->
		<main>
		</main>
	</div>
""")))}))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Aug 07 15:16:56 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/summary.scala.html
                  HASH: 6cfe58358f52ef7af0cd75a1c0bf23e510e70206
                  MATRIX: 725->1|830->18|858->21|890->45|907->54|946->56|974->58|1014->72|1028->78|1091->121
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4
                  -- GENERATED --
              */
          