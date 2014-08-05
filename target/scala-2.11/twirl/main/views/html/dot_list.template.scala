
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
object dot_list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("DOT List")/*3.18*/(message)/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_dot.js")),format.raw/*4.61*/("""" type="text/javascript"></script>
	<div class="main">
	    <table class="report">
	    	<caption>
	    		<span class="table-title">Students with more than 50% absence</span>
	    		<br />
	    		From last 120 days
	    	</caption>
	    	<thead>
	    		<th>Actions</th>
	    		<th class="uid">UID<br/>
	    			<img src=""""),_display_(/*15.20*/routes/*15.26*/.Assets.at("images/arrowup.png")),format.raw/*15.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*16.20*/routes/*16.26*/.Assets.at("images/arrow-down.png")),format.raw/*16.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="name">NAME<br/>
	    			<img src=""""),_display_(/*19.20*/routes/*19.26*/.Assets.at("images/arrowup.png")),format.raw/*19.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*20.20*/routes/*20.26*/.Assets.at("images/arrow-down.png")),format.raw/*20.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="">REFERENCE</th>
	    		<th class="sop">STAGE OF PROCESS</th>
	    		<th class="datetime_meeting">MEETING<br/>
	    			<img src=""""),_display_(/*25.20*/routes/*25.26*/.Assets.at("images/arrowup.png")),format.raw/*25.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*26.20*/routes/*26.26*/.Assets.at("images/arrow-down.png")),format.raw/*26.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="overall">OVERALL<br/>
	    			<img src=""""),_display_(/*29.20*/routes/*29.26*/.Assets.at("images/arrowup.png")),format.raw/*29.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*30.20*/routes/*30.26*/.Assets.at("images/arrow-down.png")),format.raw/*30.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    	</thead>
	    	<tbody>
	    	</tbody>
	    </table>
	</div>

    <div id="hidden_actions" title="Outcome meeting">
    	<div id="progressbar"></div>
		<form id="form_outcome" action=""""),_display_(/*40.36*/routes/*40.42*/.DotController.updateOutcome()),format.raw/*40.72*/("""" method="post" >
			<fieldset>
				<input type="hidden" name="stud_ref" id="stud_ref" />
				<input type="hidden" name="stud_uid" id="stud_uid" />
				<input type="hidden" name="stud_name" id="stud_name" />
				<input type="hidden" name="id_meeting" id="id_meeting" />
				<input type="hidden" name="cur_year" id="cur_year" />
				<input type="hidden" name="responsible_uid" id="responsible_uid" />

				<span>Student: <span id="meeting_for"></span></span>
				<br />
				<input type="checkbox" id="absent" name="absent"/>Tick if student did not come<br />
				<div id="form_group">
					<label for="date">Date</label>
					<input type="text" name="date" id="date" readonly="readonly"/>
					<br />

					<label for="hour">Time</label>
					<input type="text" name="hours" id="hours" readonly="readonly" class="time-spinner" />:
					<input type="text" name="minutes" id="minutes" readonly="readonly" class="time-spinner" />
					<span class="example">(08:00 - 18:00)</span>
					<br />

					<label for="outcome">Outcome</label><br />
					<textarea id="outcome" name="outcome" class="outcome"></textarea>
				</div>

				<input type="button" id="btn_updateOutcome" value="Submit" />
			</fieldset>
		</form>
    </div>
""")))}))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Aug 05 16:23:01 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/dot_list.scala.html
                  HASH: 357edafe12c6d6a8a7f8941822fe700ee0aedc3f
                  MATRIX: 726->1|831->18|859->21|883->37|900->46|939->48|967->50|1007->64|1021->70|1080->109|1428->430|1443->436|1496->468|1583->528|1598->534|1654->569|1789->677|1804->683|1857->715|1944->775|1959->781|2015->816|2245->1019|2260->1025|2313->1057|2400->1117|2415->1123|2471->1158|2612->1272|2627->1278|2680->1310|2767->1370|2782->1376|2838->1411|3110->1656|3125->1662|3176->1692
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|43->15|43->15|43->15|44->16|44->16|44->16|47->19|47->19|47->19|48->20|48->20|48->20|53->25|53->25|53->25|54->26|54->26|54->26|57->29|57->29|57->29|58->30|58->30|58->30|68->40|68->40|68->40
                  -- GENERATED --
              */
          