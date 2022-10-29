<template>
    <div class="hello">
      <h2> Users </h2>
      <b-table striped hover responsive :items="users" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Users" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-id">Client ID</label>
          <b-form-input
            id='input-client_Id'
            v-model="form.id"
            placeholder="Client ID"
            readonly
          ></b-form-input>
  
          <label class="sr-only" for="input-first-name">First Name</label>
          <b-form-input
            id='input-first_Name'
            v-model="form.first_name"
            placeholder="First Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-last_name">Last Name</label>
          <b-form-input
            id="input-last_Name"
            v-model="form.last_name"
            placeholder="Last Name"
            required
          ></b-form-input>

          <label class="sr-only" for="input-age">Age</label>
          <b-form-input
            id="input-age"
            v-model="form.age"
            placeholder="Age"
            required
          ></b-form-input>

          <label class="sr-only" for="input-height">Height</label>
          <b-form-input
            id="input-height"
            v-model="form.height"
            placeholder="Height"
            required
          ></b-form-input>

          <label class="sr-only" for="input-weight">Weight</label>
          <b-form-input
            id="input-weight"
            v-model="form.weight"
            placeholder="Weight"
            required
          ></b-form-input>
          
          <br />
          <b-button type="button" @click="onSave" variant="primary">Save</b-button>
          <b-button type="reset" variant="warning">Reset</b-button>
          <b-button type="button" variant="danger">Remove User</b-button>
        </b-form>
  
      </b-modal>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'HelloWorld',
    data () {
      return {
        users: null,
        fields: [
        {key: 'client_Id', label: 'Client ID', sortable: true},
        {key: 'last_Name', label: 'Last Name', sortable: true},
        {key: 'first_Name', label: 'First Name', sortable: true},
        {key: 'age', label: 'Age', sortable: true},
        {key: 'height', label: 'Height', sortable: true},
        {key: 'weight', label: 'Weight', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            id: '',
            first_name: '',
            last_name: '',
            age: '',
            height:'',
            weight:''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/users')
          .then(response => (this.users = response.data))
      },
      edit(item, index, button) {
        this.form.id = item.id
        this.form.first_name = item.first_Name
        this.form.last_name = item.last_Name
        this.form.age = item.age
        this.form.height = item.height
        this.form.weight = item.weight
      },
      resetEditModal() {
        this.form.id=''
        this.form.first_name=''
        this.form.last_name=''
        this.form.age=''
        this.form.height=''
        this.form.weight=''
      },
      onSave(event) {
        var numId;
        numId = parseInt(this.form.id);
        axios
          .put('http://localhost:8085/users/' + numId, {
            "id": numId,
            "first_Name": this.form.first_name,
            "last_Name": this.form.last_name,
            "age": this.form.age,
            "height": this.form.height,
            "weight": this.form.weight,
          })
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          });
      }
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  </style>
  