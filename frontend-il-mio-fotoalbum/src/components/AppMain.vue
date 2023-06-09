<script>
import PhotosSection from "./main/PhotosSection.vue";
import ContactSection from "./main/ContactSection.vue";

export default {
  name: "AppMain",

  components: {
    PhotosSection,
    ContactSection,
  },
};
</script>

<template>
  <main>
    <PhotosSection />
    <ContactSection />
  </main>
</template>

<style scoped></style>
