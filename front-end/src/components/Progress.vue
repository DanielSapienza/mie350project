<template>
  <div class="hello">
    <h2> Progress </h2>
    <b-table striped hover responsive :items="progress" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Progress" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-userProgressKey">Progress ID</label>
        <b-form-input
          id='input-userProgressKey'
          v-model="form.userProgressKey"
          placeholder="Progress Id"
          readonly
        ></b-form-input>



        <label class="sr-only" for="input-goal">Goal</label>
        <b-form-input
          id='input-goal'
          v-model="form.goal"
          placeholder="Goal"
          required
        ></b-form-input>

        <label class="sr-only" for="input-progressScore">Progress Score</label>
        <b-form-input
          id="input-progressScore"
          v-model="form.progressScore"
          placeholder="Progress Score"
          required
        ></b-form-input>

        <label class="sr-only" for="input-reflection">Reflection</label>
        <b-form-input
          id="input-reflection"
          v-model="form.reflection"
          placeholder="Reflection"
          required
        ></b-form-input>

        
        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Progress</b-button>
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
      progress: null,
      fields: [
      {key: 'userProgressKey', label: 'Progress ID', sortable: true},
      {key: 'goal', label: 'Goal', sortable: true},
      {key: 'progressScore', label: 'Progress Score', sortable: true},
      {key: 'reflection', label: 'Reflection', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          userProgressKey: '',
          goal: '',
          progressScore: '',
          reflection: ''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/progress')
        .then(response => (this.progress = response.data))
    },
    edit(item, index, button) {
      console.log("testing")
      this.form.userProgressKey = item.userProgressKey
      this.form.goal = item.goal
      this.form.progressScore = item.progressScore
      this.form.reflection = item.reflection
      
    },
    resetEditModal() {
      this.form.userProgressKey =''
      this.form.goal =''
      this.form.progressScore =''
      this.form.reflection =''
    },
    onSave(event) {
      var progressId;
      var client;
      progressId = (this.form.userProgressKey.progressId)
      client = parseInt(this.form.userProgressKey.clientId)
      axios
        .put('http://localhost:8085/progress/' + client +'/' + progressId, {
          "userProgressKey": this.form.userProgressKey,
          "goal": this.form.goal,
          "progressScore": this.progressScore,
          "reflection": this.form.reflection,
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
