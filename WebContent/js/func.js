function allPlayerList(teamid){
	console.log(teamid);
	$.ajax({
		type:"post",
		url:"/baseball/base?cmd=allPlayer",
		data:"teamid="+teamid,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
	})
	.done(function(playerlists) {
		//console.log("되나?")
		$("#playerlist").empty();
		//console.log(playerlists);
		renderplayer(playerlists);
		$("#playerlist").val("");
		
	})
	.fail(function(error) {
		alert("실패");
	})
}

function detailPlayerList(playid){
	console.log(playid);
	$.ajax({
		type:"post",
		url:"/baseball/base?cmd=detail",
		data:"playid="+playid,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
	})
	.done(function(playerdetaillist) {
		console.log("되나?")
		$("#playerdetaillist").empty();
		console.log(playerdetaillist);
		makedetailplayer(playerdetaillist);
		$("#playerdetaillist").val("");
		
	})
	.fail(function(error) {
		alert("실패");
	})
}


function renderplayer(playerlists) {
	//alert("요기까진 와영");
	//console.log(playerlistJson);
	for (var playerlist of playerlists) {
		$("#playerlist").append(makeplayer(playerlist));
		//console.log(playerlist);
		
	}
}

function makeplayer(playerlist) {
	//alert("이건?");
	//console.log(playerlist);
	var playerItem=`<tr id="playerlist">`;
	playerItem += `<td onclick="detailPlayerList(${playerlist.playid})">${playerlist.playnum}</td>`;
	playerItem += `<td onclick="detailPlayerList(${playerlist.playid})">${playerlist.playname}</td>`;
	playerItem += `</tr>`;
	
	return playerItem;
}


function makedetailplayer(playerdetaillist) {
	//alert("이건?");
	console.log("playerdetaillist : "+playerdetaillist);
	console.log(playerdetaillist);
	var detailplayerItem= `<tr>`;
	detailplayerItem += `<td >${playerdetaillist.playnum}</td>`;
	detailplayerItem += `<td >${playerdetaillist.playname}</td>`;
	detailplayerItem += `<td >${playerdetaillist.playposition}</td>`;
	detailplayerItem += `</tr>`;
	
	$("#playerdetaillist").append(detailplayerItem);
}

