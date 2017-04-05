
<section class="pagination-section">
	<div class="row">
		<div class="col-md-2">
			<input type="button" id="begin" value="<<" class=" btn btn-info btn-lg" />
		</div>
		<div class="col-sm-2">
			<input type="button" id="less" value="<" class=" btn btn-info btn-lg" />
		</div>
		<form id="skipPagination">
			<div class="col-sm-2">
				<div class="row">
					<div class="col-md-6">
						<input type="number" id="numberPage" value="1" min="1"
							class="form-control" />
					</div>
					<div class="col-md-6">
						<p>
							pages of <span id="totalNumberPages" />
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-2">
				<input type="submit" id="goPage" value="Go"
					class="btn btn-info btn-lg" />
			</div>
		</form>
		<div class="col-sm-2">
			<input type="button" id="more" value=">" class="btn btn-info btn-lg" />
		</div>
		<div class="col-sm-2">
			<input type="button" id="last" value=">>" class="btn btn-info btn-lg" />
		</div>
	</div>
</section>