<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class FeeGroup extends CI_Controller {

    function __construct() {
        parent::__construct();
        $this->load->helper('file');
        $this->lang->load('message', 'english');
        $this->load->library('auth');
        $this->auth->is_logged_in_accountant();
    }

    function index() {
        $this->session->set_userdata('top_menu', 'Fees Collection');
        $this->session->set_userdata('sub_menu', 'accountant/feegroup');
        $data['title'] = 'Add FeeGroup';
        $data['title_list'] = 'Recent FeeGroups';

        $this->form_validation->set_rules(
                'name', 'Name', array(
            'required',
            array('check_exists', array($this->feegroup_model, 'check_exists'))
                )
        );
        if ($this->form_validation->run() == FALSE) {
            
        } else {
            $data = array(
                'name' => $this->input->post('name'),
                'description' => $this->input->post('description'),
            );
            $this->feegroup_model->add($data);
            $this->session->set_flashdata('msg', '<div class="alert alert-success text-left">Fees Group added successfully</div>');
            redirect('accountant/feegroup/index');
        }
        $feegroup_result = $this->feegroup_model->get();
        $data['feegroupList'] = $feegroup_result;

        $this->load->view('layout/accountant/header', $data);
        $this->load->view('accountant/feegroup/feegroupList', $data);
        $this->load->view('layout/accountant/footer', $data);
    }

    function delete($id) {
        $data['title'] = 'Fees Master List';
        $this->feegroup_model->remove($id);
        redirect('accountant/feegroup/index');
    }

    function edit($id) {
        $this->session->set_userdata('top_menu', 'Fees Collection');
        $this->session->set_userdata('sub_menu', 'accountant/feegroup');
        $data['id'] = $id;
        $feegroup = $this->feegroup_model->get($id);
        $data['feegroup'] = $feegroup;
        $feegroup_result = $this->feegroup_model->get();
        $data['feegroupList'] = $feegroup_result;
        $this->form_validation->set_rules(
                'name', 'Name', array(
            'required',
            array('check_exists', array($this->feegroup_model, 'check_exists'))
                )
        );

        if ($this->form_validation->run() == FALSE) {
            $this->load->view('layout/accountant/header', $data);
            $this->load->view('accountant/feegroup/feegroupEdit', $data);
            $this->load->view('layout/accountant/footer', $data);
        } else {
            $data = array(
                'id' => $id,
                'name' => $this->input->post('name'),
                'description' => $this->input->post('description'),
            );
            $this->feegroup_model->add($data);
            $this->session->set_flashdata('msg', '<div class="alert alert-success text-left">Fees Group updated successfully</div>');
            redirect('accountant/feegroup/index');
        }
    }

}

?>