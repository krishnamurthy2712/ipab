package com.ipab.view
{
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.controls.MenuBar;
	import mx.events.MenuEvent;
	
	import spark.components.supportClasses.SkinnableComponent;
	
	public class ApplicationHeader extends SkinnableComponent
	{
		[SkinPart(required="true")]
		public var mainMenu:MenuBar;
		
		[Bindable]
		public var menuBarCollection:XMLListCollection;
		
		private var menubarXML:XMLList =<>
					<menu label="Home" data="1"/>
					<menu label="Tell Us Your Bribe Story" data="2">
						<menuitem label="I paid a bribe" data="2A"/>
						<menuitem label="I didn't pay a bribe" data="2B"/>
						<menuitem label="I didn't have to pay a bribe" data="2C"/>
						<menuitem label="Private Sector Complaints" data="2D"/>
					</menu>
					<menu label="Read Bribe Stories"  data="3">
						<menuitem label="I paid a bribe" data="3A"/>
						<menuitem label="I didn't pay a bribe" data="3B"/>
						<menuitem label="I didn't have to pay a bribe" data="3C"/>
						<menuitem label="Private Sector Complaints" data="3D"/>
						<menuitem label="SMS Complaints" data="3E"/>
					</menu>
					<menu label="Blog"  data="4"/>
					<menu label="Ask Raghu"  data="5">
						<menuitem label="Ask raghu" data="5A"/>
						<menuitem label="Raghu's answers" data="5B"/>
					</menu>
					<menu label="Forum"  data="6"/>
					<menu label="Awards"  data="7"/>
					<menu label="ACT" data="8"/>
					</>;
		
		
		public function ApplicationHeader()
		{
			
		}
		
		override protected function partAdded(partName:String, instance:Object):void
		{
			if(instance==mainMenu)
			{
				menuBarCollection = new XMLListCollection(menubarXML);
				mainMenu.dataProvider = menuBarCollection;
				mainMenu.addEventListener(MenuEvent.ITEM_CLICK, menuItemClicked);
			}
		}
		
		private function menuItemClicked(evt:MenuEvent):void
		{
			trace("" + evt);
		}
		
		override protected function partRemoved(partName:String, instance:Object):void
		{
			
		}
	}
}