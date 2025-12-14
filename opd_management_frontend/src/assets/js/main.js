(function() {
  "use strict";

  /* ================= SCROLL HEADER ================= */
  function toggleScrolled() {
    const body = document.querySelector('body');
    const header = document.querySelector('#header');

    if (!header || !body) return;

    if (
      !header.classList.contains('scroll-up-sticky') &&
      !header.classList.contains('sticky-top') &&
      !header.classList.contains('fixed-top')
    ) return;

    window.scrollY > 100
      ? body.classList.add('scrolled')
      : body.classList.remove('scrolled');
  }

  document.addEventListener('scroll', toggleScrolled);
  window.addEventListener('load', toggleScrolled);

  /* ================= MOBILE NAV ================= */
  const mobileNavToggleBtn = document.querySelector('.mobile-nav-toggle');

  function mobileNavToggle() {
    document.body.classList.toggle('mobile-nav-active');
    mobileNavToggleBtn.classList.toggle('bi-list');
    mobileNavToggleBtn.classList.toggle('bi-x');
  }

  if (mobileNavToggleBtn) {
    mobileNavToggleBtn.addEventListener('click', mobileNavToggle);
  }

  /* ================= NAV MENU LINKS ================= */
  document.querySelectorAll('#navmenu a').forEach(link => {
    link.addEventListener('click', () => {
      if (document.body.classList.contains('mobile-nav-active')) {
        mobileNavToggle();
      }
    });
  });

  /* ================= DROPDOWN ================= */
  document.querySelectorAll('.navmenu .toggle-dropdown').forEach(item => {
    item.addEventListener('click', function(e) {
      e.preventDefault();
      this.parentNode.classList.toggle('active');
      if (this.parentNode.nextElementSibling) {
        this.parentNode.nextElementSibling.classList.toggle('dropdown-active');
      }
      e.stopImmediatePropagation();
    });
  });

  /* ================= PRELOADER ================= */
  const preloader = document.querySelector('#preloader');
  if (preloader) {
    window.addEventListener('load', () => preloader.remove());
  }

  /* ================= SCROLL TOP ================= */
  const scrollTop = document.querySelector('.scroll-top');

  function toggleScrollTop() {
    if (!scrollTop) return;
    window.scrollY > 100
      ? scrollTop.classList.add('active')
      : scrollTop.classList.remove('active');
  }

  if (scrollTop) {
    scrollTop.addEventListener('click', e => {
      e.preventDefault();
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }

  window.addEventListener('load', toggleScrollTop);
  document.addEventListener('scroll', toggleScrollTop);

  /* ================= AOS ================= */
  if (typeof AOS !== 'undefined') {
    window.addEventListener('load', () => {
      AOS.init({
        duration: 600,
        easing: 'ease-in-out',
        once: true,
        mirror: false
      });
    });
  }

  /* ================= GLIGHTBOX ================= */
  if (typeof GLightbox !== 'undefined') {
    GLightbox({ selector: '.glightbox' });
  }

  /* ================= PURE COUNTER ================= */
  if (typeof PureCounter !== 'undefined') {
    new PureCounter();
  }

  /* ================= FAQ ================= */
  document.querySelectorAll('.faq-item h3, .faq-item .faq-toggle').forEach(item => {
    item.addEventListener('click', () => {
      if (item.parentNode) {
        item.parentNode.classList.toggle('faq-active');
      }
    });
  });

  /* ================= SWIPER ================= */
  function initSwiper() {
    if (typeof Swiper === 'undefined') return;

    document.querySelectorAll('.init-swiper').forEach(swiperElement => {
      const configEl = swiperElement.querySelector('.swiper-config');
      if (!configEl) return;

      const config = JSON.parse(configEl.innerHTML.trim());
      new Swiper(swiperElement, config);
    });
  }

  window.addEventListener('load', initSwiper);

})();
