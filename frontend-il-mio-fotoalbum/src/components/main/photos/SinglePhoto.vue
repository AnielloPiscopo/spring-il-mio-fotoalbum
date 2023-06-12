<script>
import { store } from "../../../store";

export default {
  name: "SinglePhoto",

  props: {
    photo: {
      required: true,
    },
  },

  data() {
    return {
      store,
    };
  },
};
</script>

<template>
  <div :title="photo.title">
    <h1>{{ photo.title }}</h1>
    <img
      v-if="photo.imgUrl"
      :src="photo.imgUrl"
      @error="photo.imgUrl = store.DEFAULT_IMG_URL"
      :alt="photo.title"
    />
    <div>{{ photo.description }}</div>
  </div>
</template>

<style scoped></style>
