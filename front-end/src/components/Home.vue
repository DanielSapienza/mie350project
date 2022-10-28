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
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="Indy!"
        img-src="https://image.petmd.com/files/styles/863x625/public/2022-06/gray.dumbo_.rat_.jpg"
      ></b-carousel-slide>
      
      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://image.petmd.com/files/styles/863x625/public/2022-06/rat.blanket.jpg">
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://i.natgeofe.com/n/73c00c4f-a746-4d0b-a006-ea5c5097d265/01-rat-friends-nationalgeographic_1162144_16x9.jpg?w=1200"></b-carousel-slide>

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
