<template>
  <div>
    <b-carousel
      id="carousel-1"
      :interval="4000"
      controls
      indicators
      fade
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
    >
      <!-- Slides with alt text -->
      <b-carousel-slide
      caption="Components of health and wellness"  
      img-src="https://www.langs.org/covid-19/health-and-well-being/health-and-wellness.jpg"
      ></b-carousel-slide>
      
      <!-- Slides with custom text -->
      
      <b-carousel-slide
        caption="Personal Health Application" 
        img-src="http://foodandhealth.com/clipart.php/view/951/?download=1"
      ></b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://media.istockphoto.com/vectors/set-of-men-and-women-exercise-at-home-using-the-house-as-a-gym-vector-id1220576876?k=20&m=1220576876&s=612x612&w=0&h=436tV4wL8JHGkYDUANYAQzBQIq6mvclICbA96-Uy2Ws="></b-carousel-slide>

    </b-carousel>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
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
