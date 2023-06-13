<script>
import { store } from "../../store";
import axios from "axios";

import PhotosList from "./photos/PhotosList.vue";
import PhotosBtnContainer from "./photos/BtnContainer.vue";

export default {
  name: "PhotosSection",

  components: {
    PhotosList,
    PhotosBtnContainer,
  },

  data() {
    return {
      store,
      photosList: [],
      apiUrlSpecificSection: "/photos",
      inputStr: "",
      isCarousel: false,
      activePhotosIndex: 0,
      autoPlay: null,
      intervalPresence: true,
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
        })
        .then((res) => {
          this.manageInterval();
        });
    },

    resetIndex() {
      this.activePhotosIndex = 0;
    },

    decreaseIndex(arrLength) {
      this.activePhotosIndex =
        this.activePhotosIndex <= 0
          ? arrLength - 1
          : this.activePhotosIndex - 1;
    },

    increaseIndex(arrLength) {
      this.activePhotosIndex =
        this.activePhotosIndex >= arrLength - 1
          ? 0
          : this.activePhotosIndex + 1;
    },

    changeSlide(currentIndex) {
      this.activePhotosIndex = currentIndex;
    },

    manageInterval() {
      console.log(this.intervalPresence);
      if (this.intervalPresence) {
        this.autoPlay = setInterval(
          this.increaseIndex,
          3000,
          this.photosList.length
        );
      } else {
        clearInterval(this.autoPlay);
      }
    },

    showInitialAlertMessage() {
      alert(
        "Le immagini del carosello andranno avanti ogni 3s circa automaticamente a meno che tu non tenga il puntatore all'interno dello slyder"
      );
    },
  },

  created() {
    this.getPhotosInfo();
  },

  computed: {
    filteredPhotosList() {
      return this.photosList.filter((photo) => {
        return photo.title.includes(this.inputStr.toLowerCase());
      });
    },

    photosNum() {
      return this.filteredPhotosList.length;
    },
  },
};
</script>

<template>
  <section id="photos">
    <div class="container-fluid">
      <h1>Lista foto</h1>
      <input
        type="text"
        v-model="inputStr"
        placeholder="Cerca per titolo"
        @change="getNumOfPhotos"
      />
      <span>{{ photosNum }}</span>

      <div class="my_radio-btns-container">
        <input
          type="radio"
          name="layout"
          :value="false"
          id="list"
          v-model="isCarousel"
        />
        <label for="list">Lista</label>

        <input
          type="radio"
          name="layout"
          :value="true"
          id="carousel"
          v-model="isCarousel"
        />
        <label for="carousel">Carosello</label>
      </div>

      <PhotosList
        :photos="filteredPhotosList"
        :activeIndex="activePhotosIndex"
        :isCarousel="isCarousel"
        @go-forth="increaseIndex(filteredPhotosList.length)"
      />

      <PhotosBtnContainer
        v-if="isCarousel"
        @go-back="decreaseIndex(filteredPhotosList.length)"
        @go-forth="increaseIndex(filteredPhotosList.length)"
      />

      <div class="container-fluid" v-if="isCarousel">
        <input
          type="checkbox"
          id="interval-presence-checkbox"
          v-model="intervalPresence"
          checked
          @change="manageInterval()"
        />
        <label for="interval-presence-checkbocx">Autoplay</label>
      </div>
    </div>
  </section>
</template>

<style scoped></style>
