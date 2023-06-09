<script>
import LogoContainer from "../LogoContainer.vue";

export default {
  name: "HeaderNavBar",

  components: {
    LogoContainer,
  },

  data() {
    return {
      navLinks: [
        {
          id: "#photos",
          text: "Foto",
        },

        {
          id: "#contact",
          text: "Zona contatti",
        },
      ],
    };
  },
};
</script>

<template>
  <nav>
    <LogoContainer />

    <ul>
      <li v-for="navLink in navLinks">
        <a :href="navLink.id" :title="'Sezione: ' + navLink.text">{{
          navLink.text
        }}</a>
      </li>
    </ul>
  </nav>
</template>

<style scoped></style>
