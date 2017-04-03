/**
 * this file is dedicated to the pagination content
 */

var pageSize = 10;
var offset = 0;
var totalValues = 10;
$("#more").attr("disabled", "disabled");
$("#last").attr("disabled", "disabled");
$("#less").attr("disabled", "disabled");
$("#begin").attr("disabled", "disabled");

/**
 * method used to verify paged responses
 * 
 * @param acientID
 *            ancient id
 * @param actualID
 *            id of actual form
 * @returns status
 */
function verifyPagedResponse(acientID, actualID, values) {
	var status = false;
	var numberOfPages = 0;
	if (totalValues < 10) {
		numberOfPages = 1;
	} else {
		numberOfPages = Math.round((values + pageSize - 1) / pageSize);
	}
	$("#numberPage").attr("max", numberOfPages);
	$("#totalNumberPages").text(numberOfPages);
	if (acientID == actualID) {
		if ((totalValues - offset) < pageSize) {
			$("#more").attr("disabled", "disabled");
			$("#last").attr("disabled", "disabled");

		} else {
			$("#more").removeAttr("disabled");
			$("#last").removeAttr("disabled");
		}
		if (offset <= 1) {
			offset = 1;
			$("#less").attr("disabled", "disabled");
			$("#begin").attr("disabled", "disabled");
		} else {
			$("#less").removeAttr("disabled");
			$("#begin").removeAttr("disabled");
		}
		status = true;
	} else {
		offset = 1;
		if ((totalValues - offset) < pageSize) {
			$("#more").attr("disabled", "disabled");
			$("#last").attr("disabled", "disabled");
		} else {
			$("#more").removeAttr("disabled");
			$("#last").removeAttr("disabled");
		}
		$("#less").attr("disabled", "disabled");
		$("#begin").attr("disabled", "disabled");
		$("#numberPage").val(1);
	}
	return status;
}

$("#begin").click(function() {
	offset = 1;
	$("#numberPage").val("1");
	$(".result").remove();
	$(idForm).submit();
});

$("#more").click(function() {
	if (offset == 1) {
		offset = 10;
	} else {
		offset += 10;
	}
	$("#numberPage").val(parseInt($("#numberPage").val()) + 1);
	$(".result").remove();
	$(idForm).submit();
});

$("#less").click(function() {
	offset -= 10;
	if (offset < 1) {
		offset = 1
	}

	$("#numberPage").val(parseInt($("#numberPage").val()) - 1);
	$(".result").remove();
	$(idForm).submit();
});

$("#last").click(function() {
	offset = parseInt(totalValues / pageSize) * 10;
	$("#numberPage").val($("#totalNumberPages").text());
	$(".result").remove();
	$(idForm).submit();
});

$(function() {
	$("#skipPagination").submit(function() {
		var numberPage = $("#numberPage").val();
		if (numberPage <= 1)
			offset = 1;
		else
			offset = parseInt("" + (numberPage - 1) * 10);
		$(".result").remove();
		$(idForm).submit();
		return false;
	});
});