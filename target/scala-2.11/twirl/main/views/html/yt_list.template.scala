
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
object yt_list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Year tutor list")/*3.25*/(message)/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_year_tutor.js")),format.raw/*4.68*/("""" type="text/javascript"></script>
	<div class="main">
	    <table class="report">
	    	<caption>
	    		<span class="table-title">Students with more than 50% absence</span>
	    		<br />
	    		From last 120 days
	    	</caption>
	    	<thead>
	    		<th>Actions</th>
	    		<th class="uid">UID</th>
	    		<th class="name">NAME</th>
	    		<th class="">REFERENCE</th>
	    		<th class="sop">STAGE OF PROCESS</th>
	    		<th class="tutor">TUTOR</th>
	    		<th class="datetime_meeting">MEETING</th>
	    		<th class="">OVERALL ATTENDANCE</th>
	    	</thead>
	    	<tbody>
	    	</tbody>
	    </table>
	</div>

    <div id="hidden_actions" title="Outcome meeting">
    	<div id="progressbar"></div>
		<form id="form_outcome" action=""""),_display_(/*29.36*/routes/*29.42*/.YearTutorController.updateOutcome()),format.raw/*29.78*/("""" method="post" >
			<fieldset>
				<input type="hidden" name="stud_ref" id="stud_ref" />
				<input type="hidden" name="stud_uid" id="stud_uid" />
				<input type="hidden" name="stud_name" id="stud_name" />
				<input type="hidden" name="id_meeting" id="id_meeting" />
				<input type="hidden" name="cur_year" id="cur_year" />
				<input type="hidden" name="year_tutor_uid" id="year_tutor_uid" />

				<span>Student: <span id="meeting_for"></span></span>
				<br />
				<input type="checkbox" id="absent" name="absent"/>Tick if student did not come<br />
				<label for="date">Date</label>
				<input type="text" name="date" id="date" readonly="readonly"/>
				<br />

				<label for="hour">Time</label>
				<input type="text" name="hours" id="hours" readonly="readonly" class="time-spinner" />:
				<input type="text" name="minutes" id="minutes" readonly="readonly" class="time-spinner" />
				<span class="example">(08:00 - 18:00)</span>
				<br />

				<label for="outcome">Outcome</label><br />
				<textarea id="outcome" name="outcome" class="outcome"></textarea><br />

				<input type="button" id="btn_updateOutcome" value="Submit" />
			</fieldset>
		</form>
    </div>
""")))}),format.raw/*58.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jul 24 11:15:29 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/yt_list.scala.html
                  HASH: 05958b2e061172630e797a92102b39c27b68b46e
                  MATRIX: 725->1|830->18|858->21|889->44|906->53|945->55|973->57|1013->71|1027->77|1093->123|1855->858|1870->864|1927->900|3137->2080
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|57->29|57->29|57->29|86->58
                  -- GENERATED --
              */
          