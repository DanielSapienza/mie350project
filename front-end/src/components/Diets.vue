<template>
    <div class="hello">
      <h2> Diets </h2>
      <b-table striped hover responsive :items="diets" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Diets" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-id">Diet ID</label>
          <b-form-input
            id='input-diet_Id'
            v-model="form.id"
            placeholder="Diet Id"
            readonly
          ></b-form-input>
  
          <label class="sr-only" for="input-name">Name</label>
          <b-form-input
            id='input-name'
            v-model="form.name"
            placeholder="Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-food_Group">Food Group</label>
          <b-form-input
            id="input-food_Group"
            v-model="form.food_Group"
            placeholder="Food Group"
            required
          ></b-form-input>

          <label class="sr-only" for="input-calories_Per_Serving">Calories Per Serving</label>
          <b-form-input
            id="input-calories_Per_Serving"
            v-model="form.calories_Per_Serving"
            placeholder="Calories Per Serving"
            required
          ></b-form-input>

          <label class="sr-only" for="input-sugar_Per_Serving">Sugar Per Serving</label>
          <b-form-input
            id="input-sugar_Per_Serving"
            v-model="form.sugar_Per_Serving"
            placeholder="Sugar Per Serving"
            required
          ></b-form-input>

          <label class="sr-only" for="input-protein_Per_Serving">Protein Per Serving</label>
          <b-form-input
            id="input-protein_Per_Serving"
            v-model="form.protein_Per_Serving"
            placeholder="Protein Per Serving"
            required
          ></b-form-input>

          <label class="sr-only" for="input-carbohydrates_Per_Serving">Carbohydrates Per Serving</label>
          <b-form-input
            id="input-carbohydrates_Per_Serving"
            v-model="form.carbohydrates_Per_Serving"
            placeholder="Carbohydrates Per Serving"
            required
          ></b-form-input>
          
          <br />
          <b-button type="button" @click="onSave" variant="primary">Save</b-button>
          <b-button type="reset" variant="warning">Reset</b-button>
          <b-button type="button" variant="danger">Remove Diet</b-button>
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
        diets: null,
        fields: [
        {key: 'diet_Id', label: 'Diet ID', sortable: true},
        {key: 'name', label: 'Name', sortable: true},
        {key: 'food_Group', label: 'Food Group', sortable: true},
        {key: 'calories_Per_Serving', label: 'Calories Per Serving', sortable: true},
        {key: 'sugar_Per_Serving', label: 'Sugar Per Serving', sortable: true},
        {key: 'protein_Per_Serving', label: 'Protein Per Serving', sortable: true},
        {key: 'carbohydrates_Per_Serving', label: 'Carbohydrates Per Serving', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            id: '',
            name: '',
            food_Group: '',
            calories_Per_Serving: '',
            sugar_Per_Serving:'',
            protein_Per_Serving:'',
            carbohydrates_Per_Serving:''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/diets')
          .then(response => (this.diets = response.data))
      },
      edit(item, index, button) {
        this.form.id = item.id
        this.form.name = item.name
        this.form.food_Group = item.food_Group
        this.form.sugar_Per_Serving = item.sugar_Per_Serving
        this.form.protein_Per_Serving = item.protein_Per_Serving
        this.form.carbohydrates_Per_Serving = item.carbohydrates_Per_Serving
        
      },
      resetEditModal() {
        this.form.id=''
        this.form.name=''
        this.form.food_Group=''
        this.form.sugar_Per_Serving=''
        this.form.protein_Per_Serving=''
        this.form.carbohydrates_Per_Serving=''
      },
      onSave(event) {
        var numId;
        numId = parseInt(this.form.id);
        axios
          .put('http://localhost:8085/diets/' + numId, {
            "id": numId,
            "name": this.form.name,
            "food_Group": this.form.food_Group,
            "sugar_Per_Serving": this.form.sugar_Per_Serving,
            "protein_Per_Serving": this.form.protein_Per_Serving,
            "carbohydrates_Per_Serving": this.form.carbohydrates_Per_Serving,
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
  