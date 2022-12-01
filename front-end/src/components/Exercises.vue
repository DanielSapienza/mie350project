<template>
  <div class="hello">
    <h2> Exercises </h2>
    <b-table striped hover responsive :items="exercise" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Exercises" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-userExerciseKey">Exercise ID</label>
        <b-form-input
          id='input-userExerciseKey'
          v-model="form.userExerciseKey"
          placeholder="Exercise Id"
          readonly
        ></b-form-input>



        <label class="sr-only" for="input-workoutName">Workout Name</label>
        <b-form-input
          id='input-workoutName'
          v-model="form.workoutName"
          placeholder="Workout Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-duration">Duration</label>
        <b-form-input
          id="input-duration"
          v-model="form.duration"
          placeholder="Duration"
          required
        ></b-form-input>

        <label class="sr-only" for="input-satisfaction">Satisfaction</label>
        <b-form-input
          id="input-satisfaction"
          v-model="form.satisfaction"
          placeholder="Satisfaction"
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
      exercise: null,
      fields: [
      {key: 'userExerciseKey', label: 'Exercise ID', sortable: true},
      {key: 'workoutName', label: 'Workout Name', sortable: true},
      {key: 'duration', label: 'Duration', sortable: true},
      {key: 'satisfaction', label: 'Satisfaction', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          userExerciseKey: '',
          workoutName: '',
          duration: '',
          satisfaction: ''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/exercise')
        .then(response => (this.exercise = response.data))
    },
    edit(item, index, button) {
      console.log("testing")
      this.form.userExerciseKey = item.userExerciseKey
      this.form.workoutName = item.workoutName
      this.form.duration = item.duration
      this.form.satisfaction = item.satisfaction
      
    },
    resetEditModal() {
      this.form.userExerciseKey =''
      this.form.workoutName =''
      this.form.duration =''
      this.form.satisfaction =''
    },
    onSave(event) {
      var exercise;
      var date;
      var client;
      date = (this.form.userExerciseKey.dayYear)
      exercise = (this.form.userExerciseworkoutId)
      client = parseInt(this.form.userExerciseKey.clientId)
      axios
        .put('http://localhost:8085/exercise/' + client +'/' + exercise + '/' + date, {
          "userExerciseKey": this.form.userExerciseKey,
          "name": this.form.workoutName,
          "duration": this.duration,
          "satisfaction": this.form.satisfaction,
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
