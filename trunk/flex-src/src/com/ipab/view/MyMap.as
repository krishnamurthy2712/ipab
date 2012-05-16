package com.ipab.view
{
	import spark.components.Group;
	import spark.components.supportClasses.SkinnableComponent;
	
	public class MyMap extends SkinnableComponent
	{
		[Skinpart(required="true")]
		public var countyHolder:Group;
		
		
		public function MyMap()
		{
			super();
		}
		
		override protected function partAdded(partName:String, instance:Object):void
		{
			
		}
		
		override protected function partRemoved(partName:String, instance:Object):void
		{
			
		}
	}
}