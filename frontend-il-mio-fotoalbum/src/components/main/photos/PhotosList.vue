<script>
import SinglePhoto from "./SinglePhoto.vue";

export default {
  name: "PhotosList",

  components: {
    SinglePhoto,
  },

  props: {
    photos: {
      required: true,
    },

    activeIndex: {
      required: true,
    },
  },
};
</script>

<template>
  <div class="my_carousel-wrapper d-flex">
    <SinglePhoto v-if="photos[activeIndex]" :photo="photos[activeIndex]" />
  </div>
</template>

<style scoped></style>
