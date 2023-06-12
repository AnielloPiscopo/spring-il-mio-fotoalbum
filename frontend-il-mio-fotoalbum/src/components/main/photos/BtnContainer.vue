<script>
export default {
  name: "PhotosBtnContainer",

  data() {
    return {
      btnsList: [
        {
          name: "Prev",
          emit: "go-back",
        },

        {
          name: "Next",
          emit: "go-forth",
        },
      ],
    };
  },
};
</script>

<template>
  <div class="row">
    <button
      v-for="(btn, index) in btnsList"
      :key="index"
      class="col-3 col-lg-2"
      @click="$emit(btn.emit)"
    >
      {{ btn.name }}
    </button>
  </div>
</template>

<style scoped></style>
