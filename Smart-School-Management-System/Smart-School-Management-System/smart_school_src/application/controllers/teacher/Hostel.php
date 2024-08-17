<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Hostel extends CI_Controller {

    function __construct() {
        parent::__construct();
        $this->lang->load('message', 'english');
        $this->load->library('Customlib');
        $this->load->library('auth');
        $this->auth->is_logged_in_teacher();
    }

    public function index() {
        $this->session->set_userdata('top_menu', 'Hostel');
        $this->session->set_userdata('sub_menu', 'teacher/hostel/index');
        $listhostel = $this->hostel_model->listhostel();
        $data['listhostel'] = $listhostel;
        $ght = $this->customlib->getHostaltype();
        $data['ght'] = $ght;
        $this->load->view('layout/teacher/header');
        $this->load->view('teacher/hostel/createhostel', $data);
        $this->load->view('layout/teacher/footer');
    }

    function create() {
        $data['title'] = 'Add Library';
        $this->form_validation->set_rules('hostel_name', 'Hostel Name', 'required');
        $this->form_validation->set_rules('type', 'Type', 'trim|required|xss_clean');
        if ($this->form_validation->run() == FALSE) {
            $listhostel = $this->hostel_model->listhostel();
            $data['listhostel'] = $listhostel;
            $ght = $this->customlib->getHostaltype();
            $data['ght'] = $ght;
            $this->load->view('layout/teacher/header');
            $this->load->view('teacher/hostel/createhostel', $data);
            $this->load->view('layout/teacher/footer');
        } else {
            $data = array(
                'hostel_name' => $this->input->post('hostel_name'),
                'type' => $this->input->post('type'),
                'address' => $this->input->post('address'),
                'intake' => $this->input->post('intake'),
                'description' => $this->input->post('description')
            );
            $this->hostel_model->addhostel($data);
            $this->session->set_flashdata('msg', '<div class="alert alert-success text-left">Hostel added successfully</div>');
            redirect('teacher/hostel/index');
        }
    }

    function edit($id) {
        $data['title'] = 'Add Hostel';
        $data['id'] = $id;
        $edithostel = $this->hostel_model->get($id);
        $data['edithostel'] = $edithostel;
        $ght = $this->customlib->getHostaltype();
        $data['ght'] = $ght;
        $this->form_validation->set_rules('hostel_name', 'Hostel Name', 'required');
        $this->form_validation->set_rules('type', 'Type', 'trim|required|xss_clean');
        if ($this->form_validation->run() == FALSE) {
            $listhostel = $this->hostel_model->listhostel();
            $data['listhostel'] = $listhostel;
            $this->load->view('layout/teacher/header');
            $this->load->view('teacher/hostel/edithostel', $data);
            $this->load->view('layout/teacher/footer');
        } else {
            $data = array(
                'id' => $this->input->post('id'),
                'hostel_name' => $this->input->post('hostel_name'),
                'type' => $this->input->post('type'),
                'address' => $this->input->post('address'),
                'intake' => $this->input->post('intake'),
                'description' => $this->input->post('description')
            );
            $this->hostel_model->addhostel($data);
            $this->session->set_flashdata('msg', '<div class="alert alert-success text-left">Hostel updated successfully</div>');
            redirect('teacher/hostel/index');
        }
    }

    function delete($id) {
        $data['title'] = 'Fees Master List';
        $this->hostel_model->remove($id);
        redirect('teacher/hostel/index');
    }

}

?>