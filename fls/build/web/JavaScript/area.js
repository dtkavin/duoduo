


function BindProvince(ProvinceObjId,CityObjId,AreaObjId)
{ 
	
	var pobj=document.getElementById(ProvinceObjId);
	
	for(var i=0;i<province.length;i++)
	{  
		   if(province[i].name!=null){
			   pobj.options[i]=new Option(province[i].name,province[i].id);
		   }
	}
	if(arguments.length==2)
	{
	 ProvinceChang(ProvinceObjId,CityObjId);   
	 if(window.addEventListener)
	 {
		 pobj.addEventListener('change',function(){ ProvinceChang(ProvinceObjId,CityObjId);}, false);        
	 } 
	 else 
	 { 
		 pobj.attachEvent('onchange',function(){ProvinceChang(ProvinceObjId,CityObjId);});       
	 }     
	}
	if(arguments.length==3)
	{

	  ProvinceChang(ProvinceObjId,CityObjId);   
	 if(window.addEventListener)
	 {
		 pobj.addEventListener('change',function(){ ProvinceChang(ProvinceObjId,CityObjId,AreaObjId);}, false);        
	 } 
	 else 
	 { 
		 pobj.attachEvent('onchange',function(){ProvinceChang(ProvinceObjId,CityObjId,AreaObjId);});       
	 }    
	 CityChang(CityObjId,AreaObjId);
	 var cobj=document.getElementById(CityObjId);
	 if(window.addEventListener)
	 {
		 cobj.addEventListener('change',function(){ CityChang(CityObjId,AreaObjId);}, false);        
	 } 
	 else 
	 { 
		 cobj.attachEvent('onchange',function(){CityChang(CityObjId,AreaObjId);});       
	 }     
	}
}
function ProvinceChang(ProvinceObjId,CityObjId,AreaObjId)
{
	
	 
	var cobj=document.getElementById(CityObjId);
	var pobj=document.getElementById(ProvinceObjId);
	var pid=pobj.value;
	var count=0;
   for(var i=0;i<city.length;i++)
	{
	  if(city[i].topid==pid)
	  {
	   cobj.options[count]=new Option(city[i].name,city[i].id);
	  
	   count++;
	  }
	}
	cobj.length=count;
   if(arguments.length==3)
	{
		CityChang(CityObjId,AreaObjId);
	}
}
function CityChang(CityObjId,AreaObjId)
{   

	var cobj=document.getElementById(CityObjId);
	var aobj=document.getElementById(AreaObjId);
	var cid=cobj.value;
	var count=0;
	for(var i=0;i<areas.length;i++)
	{
		 if(areas[i].topid==cid)
		{
			 aobj.options[count]=new Option(areas[i].name,areas[i].id);
			
			count++;
		}
	}
	aobj.length=count;
}
function BindDefaultVal(ProvinceObjId,CityObjId,AreaObjId,ProVal,CityVal,AreaVal)
{
	
	
	

	
	var pobj=document.getElementById(ProvinceObjId);
	var cobj=document.getElementById(CityObjId);
	var aobj=document.getElementById(AreaObjId);
	BindProvince(ProvinceObjId,CityObjId,AreaObjId);
	var pselindex=0,cselindex=0,aselindex=0;;
	for(var i=0;i<pobj.length;i++)
	{
	 if(pobj.options[i].value==ProVal)
	 {
		 pobj.selectedIndex=i;
		 pselindex=i;
	 break;
	 }
	}
	 ProvinceChang(ProvinceObjId,CityObjId,AreaObjId);

	 for(var j=0;j<cobj.length;j++)
	 {
		 if(cobj.options[j].value==CityVal)
		 {
		 cobj.selectedIndex=j;
		 cselindex=j;
		 break;
		 }
	 }
	 
	 CityChang(CityObjId,AreaObjId);
	 for(var k=0;k<aobj.length;k++)
	 {
	   if(aobj.options[k].value==AreaVal)
		 {
		 aobj.selectedIndex=k;
		 aselindex=k;
		 break;
		 }
	 }
	
}