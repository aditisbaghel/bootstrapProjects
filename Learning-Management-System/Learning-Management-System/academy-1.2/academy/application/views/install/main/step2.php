<?php if(isset($error)) { ?>
  <div class="row"
    style="margin-top: 20px;">
    <div class="col-md-8 col-md-offset-2">
      <div class="alert alert-danger">
        <strong><?php echo $error; ?></strong>
      </div>
    </div>
  </div>
<?php } ?>
<div class="row"
  style="margin-top: 30px;">
  <div class="col-md-8 col-md-offset-2">
    <div class="panel panel-default" data-collapsed="0"
      style="border-color: #dedede;">
      <!-- panel body -->
      <div class="panel-body" style="font-size: 14px;">
        <p style="font-size: 14px;">
          Provide your codecanyon <strong>purchase code</strong>
        </p>
        <br>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal form-groups" method="post"
              action="<?php echo site_url('install/validate_purchase_code');?>">
              <div class="form-group">
        				<label class="col-sm-3 control-label">Purchase Code</label>
        				<div class="col-sm-7">
        					<input type="text" class="form-control" name="purchase_code" placeholder="Product's Purchase Code" value="Nulled, Enjoy!"
                    required autofocus autocomplete="off">
        				</div>
        			</div>
              <div class="form-group">
        				<label class="col-sm-3 control-label"></label>
        				<div class="col-sm-7">
        					<button type="submit" class="btn btn-info">Continue</button>
        				</div>
        			</div>
            </form>
            <br>
            <p><a target="_blank" href="https://bit.ly/2QCCRlD">Web Portal</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
