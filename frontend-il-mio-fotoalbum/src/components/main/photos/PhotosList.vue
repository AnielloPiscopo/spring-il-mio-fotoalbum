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

    isCarousel: {
      required: true,
      type: Boolean,
    },
  },
};
</script>

<template>
  <div class="my_carousel-wrapper d-flex" v-if="isCarousel">
    <SinglePhoto v-if="photos[activeIndex]" :photo="photos[activeIndex]" />
  </div>

  <div class="row" v-else>
    <SinglePhoto
      v-for="(photo, index) in photos"
      :key="index"
      :photo="photo"
      class="col-3"
    />
  </div>
</template>

<style scoped></style>
