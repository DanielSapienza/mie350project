<template>
    <div class="hello">
      <h2> Sleep </h2>
      <b-table striped hover responsive :items="sleep" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Sleep" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-userSleepKey">Sleep ID</label>
          <b-form-input
            id='input-userSleepKey'
            v-model="form.userSleepKey"
            placeholder="Sleep ID"
            readonly
          ></b-form-input>
  
          <label class="sr-only" for="input-duration">Duration</label>
          <b-form-input
            id='input-duration'
            v-model="form.duration"
            placeholder="Duration"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-restScore">Rest Score</label>
          <b-form-input
            id="input-restScore"
            v-model="form.restScore"
            placeholder="Rest Score"
            required
          ></b-form-input>

          <label class="sr-only" for="input-dream">Dream</label>
          <b-form-input
            id="input-dream"
            v-model="form.dream"
            placeholder="Dream"
            required
          ></b-form-input>

          <label class="sr-only" for="input-alarmWakeUp">Alarm Wake-Up</label>
          <b-form-input
            id="input-alarmWakeUp"
            v-model="form.alarmWakeUp"
            placeholder="Alarm Wake-Up"
            required
          ></b-form-input>

          <label class="sr-only" for="input-nNaps">Number of Naps</label>
          <b-form-input
            id="input-nNaps"
            v-model="form.nNaps"
            placeholder="Number of Naps"
            required
          ></b-form-input>

          
          <br />
          <b-button type="button" @click="onSave" variant="primary">Save</b-button>
          <b-button type="reset" variant="warning">Reset</b-button>
          <b-button type="button" variant="danger">Remove Sleep</b-button>
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
        {key: 'userSleepKey', label: 'Sleep ID', sortable: true},
        {key: 'duration', label: 'Duration', sortable: true},
        {key: 'restScore', label: 'Rest Score', sortable: true},
        {key: 'dream', label: 'Dream', sortable: true},
        {key: 'alarmWakeUp', label: 'Alarm Wake-Up', sortable: true},
        {key: 'nNaps', label: 'Number of Naps', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            userSleepKey: '',
            duration: '',
            restScore: '',
            dream: '',
            alarmWakeUp: '',
            nNaps: ''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/sleep')
          .then(response => (this.sleep = response.data))
      },
      edit(item, index, button) {
        this.form.userSleepKey = item.userSleepKey
        this.form.duration = item.duration
        this.form.restScore = item.restScore
        this.form.dream = item.dream
        this.form.alarmWakeUp = item.alarmWakeUp
        this.form.nNaps = item.nNaps
      },
      resetEditModal() {
        this.form.userSleepKey=''
        this.form.duration=''
        this.form.restScore=''
        this.form.dream=''
        this.form.alarmWakeUp=''
        this.form.nNaps=''
      },
      onSave(event) {
        var numId;
        numId = parseInt(this.form.userSleepKey);
        axios
          .put('http://localhost:8085/sleep/' + numId, {
            "userSleepKey": this.form.userSleepKey,
            "duration": this.form.duration,
            "restScore": this.form.restScore,
            "dream": this.form.dream,
            "alarmWakeUp": this.form.alarmWakeUp,
            "nNaps": this.form.nNaps,
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
  