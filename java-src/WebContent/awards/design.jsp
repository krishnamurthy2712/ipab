<div id="TabbedPanels1" class="TabbedPanels">
  <ul class="TabbedPanelsTabGroup">
    <li class="TabbedPanelsTab">Latest</li>
      <li class="TabbedPanelsTab">Most Popular</li>
    <li class="TabbedPanelsTab">Department</li>
  </ul>
  <div class="TabbedPanelsContentGroup">
    <div class="TabbedPanelsContent"><%@ include file="latest.jsp" %></div>
    <div class="TabbedPanelsContent"><%@  include file="mostpopular.jsp"  %></div>
     <div class="TabbedPanelsContent"><%@ include file="deptwise.jsp"  %></div>
  </div>
</div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>