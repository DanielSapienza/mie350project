<template>
    <div class="hello">
      <h2> Exercises </h2>
      <b-table striped hover responsive :items="exercises" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Users" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-id">Exercise ID</label>
          <b-form-input
            id='input-exercise_Id'
            v-model="form.id"
            placeholder="Exercise Id"
            readonly
          ></b-form-input>
  
          <label class="sr-only" for="input-name">Name</label>
          <b-form-input
            id='input-name'
            v-model="form.name"
            placeholder="Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-muscle_group">Muscle Group</label>
          <b-form-input
            id="input-muscle_Group"
            v-model="form.muscle_Group"
            placeholder="Muscle_Group"
            required
          ></b-form-input>

          <label class="sr-only" for="input-repetitions">Repetitions</label>
          <b-form-input
            id="input-repetitions"
            v-model="form.repetitions"
            placeholder="Repetitions"
            required
          ></b-form-input>

          <label class="sr-only" for="input-heart_Beats_Per_Min">Heart Beats Per Min</label>
          <b-form-input
            id="input-heart_Beats_Per_Min"
            v-model="form.heart_Beats_Per_Min"
            placeholder="Heart Beats Per Min"
            required
          ></b-form-input>
          
          <br />
          <b-button type="button" @click="onSave" variant="primary">Save</b-button>
          <b-button type="reset" variant="warning">Reset</b-button>
          <b-button type="button" variant="danger">Remove Exercise</b-button>
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
        exercises: null,
        fields: [
        {key: 'exercise_Id', label: 'Exercise ID', sortable: true},
        {key: 'name', label: 'Name', sortable: true},
        {key: 'muscle_Group', label: 'Muscle Group', sortable: true},
        {key: 'repetitions', label: 'Repetitions', sortable: true},
        {key: 'heart_Beats_Per_Min', label: 'Heart Beats Per Min', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            id: '',
            name: '',
            muscle_Group: '',
            repetitions: '',
            heart_Beats_Per_Min:''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/exercises')
          .then(response => (this.exercises = response.data))
      },
      edit(item, index, button) {
        this.form.id = item.id
        this.form.name = item.name
        this.form.muscle_Group = item.muscle_Group
        this.form.repetitions = item.repetitions
        this.form.heart_Beats_Per_Min = item.heart_Beats_Per_Min
      },
      resetEditModal() {
        this.form.id=''
        this.form.name=''
        this.form.muscle_Group=''
        this.form.repetitions=''
        this.form.heart_Beats_Per_Min=''
      },
      onSave(event) {
        var numId;
        numId = parseInt(this.form.id);
        axios
          .put('http://localhost:8085/exercises/' + numId, {
            "id": numId,
            "name": this.form.name,
            "muscle_Group": this.form.muscle_Group,
            "repetitions": this.form.repetitions,
            "heart_Beats_Per_Min": this.form.heart_Beats_Per_Min,
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
  