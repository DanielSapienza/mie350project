<template>
    <div class="hello">
      <h2> Diets </h2>
      <b-table striped hover responsive :items="diet" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Diets" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-userMealKey">Meal ID</label>
          <b-form-input
            id='input-userMealKey'
            v-model="form.userMealKey"
            placeholder="Meal Id"
            readonly
          ></b-form-input>



          <label class="sr-only" for="input-mealName">Meal Name</label>
          <b-form-input
            id='input-mealName'
            v-model="form.mealName"
            placeholder="Meal Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-calories">Calories</label>
          <b-form-input
            id="input-calories"
            v-model="form.calories"
            placeholder="Calories"
            required
          ></b-form-input>

          <label class="sr-only" for="input-sugar">Sugar</label>
          <b-form-input
            id="input-sugar"
            v-model="form.sugar"
            placeholder="sugar"
            required
          ></b-form-input>

          <label class="sr-only" for="input-carbs">Carbohydrates</label>
          <b-form-input
            id="input-carbs"
            v-model="form.carbs"
            placeholder="Carbohydrates"
            required
          ></b-form-input>

          <label class="sr-only" for="input-protein">Protein</label>
          <b-form-input
            id="input-protein"
            v-model="form.protein"
            placeholder="Protein"
            required
          ></b-form-input>

          <label class="sr-only" for="input-fat">Fat</label>
          <b-form-input
            id="input-fat"
            v-model="form.fat"
            placeholder="Fat"
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
        diet: null,
        fields: [
        {key: 'userMealKey', label: 'Meal ID', sortable: true},
        //{key: 'mealType', label: 'Meal Type', sortable: true},
        //{key: 'dayYear', label: 'Meal Date', sortable: true},
        {key: 'mealName', label: 'Meal Name', sortable: true},
        {key: 'calories', label: 'Calories', sortable: true},
        {key: 'sugar', label: 'Sugar', sortable: true},
        {key: 'carbs', label: 'Carbohydrates', sortable: true},
        {key: 'protein', label: 'Protein', sortable: true},
        {key: 'fat', label: 'Fat', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            userMealKey: '',
            //mealType: '',
            //dayYear: '',
            mealName: '',
            calories: '',
            sugar: '',
            carbs:'',
            protein:'',
            fat:''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/diet')
          .then(response => (this.diet = response.data))
      },
      edit(item, index, button) {
        console.log("testing")
        this.form.userMealKey = item.userMealKey
        //this.form.userMealKey.mealType = item.userMealKey.mealType
        //this.form.userMealKey.dayYear = item.userMealKey.dayYear
        this.form.mealName = item.mealName
        this.form.calories = item.calories
        this.form.sugar = item.sugar
        this.form.carbs = item.carbs
        this.form.protein = item.protein
        this.form.fat = item.fat
        
      },
      resetEditModal() {
        this.form.userMealKey=''
        //this.form.userMealKey.mealType=''
        //this.form.userMealKey.dayYear=''
        this.form.mealName=''
        this.form.calories=''
        this.form.sugar=''
        this.form.carbs=''
        this.form.protein=''
        this.form.fat=''
      },
      onSave(event) {
        var meal;
        var date;
        var client;
        date = (this.form.userMealKey.dayYear);
        meal = (this.form.userMealKey.mealType);
        client = parseInt(this.form.userMealKey.clientId);
        axios
          .put('http://localhost:8085/diet/' + client +'/' + meal + '/' + date, {
            "userMealKey": this.form.userMealKey,
            "name": this.form.mealName,
            "calories": this.calories,
            "sugar": this.form.sugar,
            "carbs": this.form.carbs,
            "protein": this.form.protein,
            "fat": this.form.fat,
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
  