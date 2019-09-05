<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">
        <img
          src="https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/spaces%2F-LEkNWEp1f8V1WZ92tOa%2Favatar.png?generation=1560536151068541&alt=media"
          class="d-inline-block align-top"
          alt="Logo"
          height="33"
          width="33"
        />
        SquadNation
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item to="register">Sign up</b-nav-item>
          <b-nav-item to="login">Sign in</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>