Type LogicCenter
	Field rt.RoomTemplates
	Field targetname$
End Type

Function AddLogicCenter.LogicCenter(rt.RoomTemplates, targetname$)
	lc.LogicCenter = New LogicCenter
	lc\rt = rt
	lc\targetname = targetname
	return lc
End Function

Type WeightedItemSpawner
	Field x#, y#, z#

	Field rt.RoomTemplates
	Field targetname$
	
	Field noneWeight%
	Field item1.WeightedItem
	Field item2.WeightedItem
	Field item3.WeightedItem
	Field item4.WeightedItem
	Field item5.WeightedItem
End Type

Function AddWeightedItemSpawner.WeightedItemSpawner(x#, y#, z#, rt.RoomTemplates, targetname$)
	is.WeightedItemSpawner = New WeightedItemSpawner
	is\x = x
	is\y = y
	is\z = z
	is\rt = rt
	is\targetname = targetname
	return is
End Function

Type WeightedItem
	Field weight%
	Field name$
	Field tempname$
End Type

Function AddWeightedItem.WeightedItem(weight%, name$, tempname$)
	wi.WeightedItem = New WeightedItem
	wi\weight = weight
	wi\name = name
	wi\tempname = tempname
	return wi
End Function

Function GetWeightedItem.WeightedItem(is.WeightedItemSpawner)
	wi.WeightedItem = New WeightedItem
	
	bucket% = is\noneWeight + is\item1\weight + is\item2\weight + is\item3\weight + is\item4\weight + is\item5\weight
	random% = Rand(0,bucket)
	If random<=is\noneWeight
		wi=Null
	ElseIf random<=(is\noneWeight+is\item1\weight)
		wi=is\item1
	ElseIf random<=(is\noneWeight+is\item1\weight+is\item2\weight)
		wi=is\item2
	ElseIf random<=(is\noneWeight+is\item1\weight+is\item2\weight+is\item3\weight)
		wi=is\item3
	ElseIf random<=(is\noneWeight+is\item1\weight+is\item2\weight+is\item3\weight+is\item4\weight)
		wi=is\item4
	ElseIf random<=(bucket)
		wi=is\item5
	Else
		wi=Null
	EndIf
	
	return wi
End Function