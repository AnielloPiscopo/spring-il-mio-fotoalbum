<script>
import { store } from "../../store";
import axios from "axios";

import PhotosList from "./photos/PhotosList.vue";

export default {
  name: "PhotosSection",

  components: {
    PhotosList,
  },

  data() {
    return {
      store,
      photosList: [],
      apiUrlSpecificSection: "/photos",
      inputStr: "",
    };
  },

  methods: {
    getPhotosInfo() {
      axios
        .get(this.store.API_URL + this.apiUrlSpecificSection, {
          params: {},
        })
        .then((res) => {
          console.log(res);
          this.photosList = res.data;
        });
    },
  },

  created() {
    this.getPhotosInfo();
  },
};
</script>

<template>
  <section id="photos">
    <h1>Lista foto</h1>
    <input type="text" v-model="inputStr" />
    <PhotosList :photos="photosList" :inputStr="inputStr" />
  </section>
</template>

<style scoped></style>
