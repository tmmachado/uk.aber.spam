
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

"""),_display_(/*3.2*/main("Student report")/*3.24*/(message)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_admin.js")),format.raw/*4.63*/("""" type="text/javascript"></script>
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
	    		<th class="">YEAR</th>
	    		<th class="yos">YEAR OF STUDY <button title="Filter" class="btn_filter">F</button></th>
	    		<th class="sop">STAGE OF PROCESS</th>
	    		<th class="">SESSIONS FOR PERIOD</th>
	    		<th class="">OVERALL ATTENDANCE</th>
	    	</thead>
	    	<tbody>
	    		<tr class="visible-row odd-row">
	    			<td><button class="bt_actions">Meeting</button></td>
	    			<td yt_uid="rpg" yt_name="Raul Peres" class="uid">tmm3</td>
	    			<td class="name">Tarcio Marinho Machado</td>
	    			<td class="stud_ref">12345678</td>
	    			<td>2014</td>
	    			<td class="yos">2</td>
	    			<td class="sop">First time</td>
	    			<td>2/8</td>
	    			<td>25%</td>
	    		</tr>
	    		<tr class="visible-row even-row">
	    			<td><button class="bt_actions">Meeting</button></td>
	    			<td yt_uid="tmm3" yt_name="Tarcio Marinho" class="uid">rpg</td>
	    			<td class="name">Raul Peres de Góes</td>
	    			<td class="stud_ref">12345678</td>
	    			<td>2014</td>
	    			<td class="yos">1</td>
	    			<td class="sop">Second time</td>
	    			<td>3/8</td>
	    			<td>37.5%</td>
	    		</tr>
	    	</tbody>
	    </table>
	</div>

		<div class="hidden_container filter_container">
			<input id="hidden_filter" type="text" />
		</div>

	    <div id="hidden_actions" title="Arrange meeting">
	    	<div id="progressbar"></div>
			<form id="arrange_meeting" action=""""),_display_(/*56.40*/routes/*56.46*/.AdminController.arrangeMeeting()),format.raw/*56.79*/("""" method="post" >
				<fieldset>
					<input type="hidden" name="stud_ref" id="stud_ref" />
					<input type="hidden" name="stud_name" id="stud_name" />
					<input type="hidden" name="stud_uid" id="stud_uid" />
					<input type="hidden" name="year_tutor_uid" id="year_tutor_uid" />
					<input type="hidden" name="year_tutor_name" id="year_tutor_name" />

					For: <span id="meeting_for"></span><br />
		    		With: <span id="meeting_with"></span><br />
		    		<!--<input id="radio_yt" type="radio" name="meeting_with" value="yt" checked="checked">Year tutor
					<input id="radio_dot" type="radio" name="meeting_with" value="dot">Director of teaching-->

					<label for="date">Date</label>
					<input type="text" name="date" id="date" readonly="readonly"/>
					<br />
					<label for="hour">Time</label>
					<input type="text" name="hours" id="hours" value="08" readonly="readonly" class="time-spinner" />:
					<input type="text" name="minutes" id="minutes" value="00" readonly="readonly" class="time-spinner" />
					<span class="example">(08:00 - 18:00)</span>
					<br />
					<label for="location">Location</label>
					<input type="text" name="location" id="location" />
					<br />
					<input type="button" id="btn_sendEmail" value="Submit" />
				</fieldset>
			</form>
	    </div>

""")))}),format.raw/*85.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jul 22 17:29:55 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/student_report.scala.html
                  HASH: 8d0261669b2f0e10a7d68ee14428aeda600365e7
                  MATRIX: 732->1|837->18|865->21|895->43|912->52|951->54|979->56|1019->70|1033->76|1094->117|2881->1877|2896->1883|2950->1916|4281->3217
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|84->56|84->56|84->56|113->85
                  -- GENERATED --
              */
          