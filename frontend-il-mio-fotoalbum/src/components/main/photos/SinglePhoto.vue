<script>
export default {
  name: "SinglePhoto",

  props: {
    photo: {
      required: true,
    },

    inputStr: {
      required: false,
    },
  },
};
</script>

<template>
  <div v-if="photo.title.includes(inputStr)">
    <h1>{{ photo.title }}</h1>
    <img :src="photo.imgUrl" alt="IMG" />
    <div>{{ photo.description }}</div>
  </div>
</template>

<style scoped></style>
