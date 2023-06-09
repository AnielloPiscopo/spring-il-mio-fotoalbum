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

    inputStr: {
      required: false,
    },
  },
};
</script>

<template>
  <div>
    <SinglePhoto
      v-for="(photo, index) in photos"
      :key="index"
      :photo="photo"
      :inputStr="inputStr"
    />
  </div>
</template>

<style scoped></style>
