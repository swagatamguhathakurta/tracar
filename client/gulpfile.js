var gulp = require('gulp'),
    clean = require('gulp-clean'),
    inject = require('gulp-inject'),
    bowerFiles = require('main-bower-files'),
    angularFileSort = require('gulp-angular-filesort'),
    browserSync = require('browser-sync').create();

var config = {
    paths: {
        src: './src',
        build: './build',
        bower: './bower_component'
    }
};

gulp.task('clean', function () {
    return gulp.src(config.paths.build, {read:false})
        .pipe(clean());
});


gulp.task('inject', function () {
    var cssFiles = gulp.src([
        config.paths.src + '/**/*.css'
        ], {read:false});

    var jsFiles = gulp.src([
        config.paths.src + '/**/*.js'
    ]);

    return gulp.src(config.paths.src + '/index.html')
        .pipe(inject(gulp.src(bowerFiles(), {read: false}), {name: 'bower'}))
        .pipe(inject(cssFiles, {ignorePath: 'src', addRootSlash: false}))
        .pipe(inject(jsFiles.pipe(angularFileSort()), {ignorePath: 'src', addRootSlash: false} ))
        .pipe(gulp.dest(config.paths.build));
});

gulp.task('serve', ['inject'], function () {
    browserSync.init({
        server: {
            baseDir: [config.paths.build, config.paths.bower, config.paths.src],
            routes: {
                '/bower_components':'bower_components'
            }
        },
        files: [
            config.paths.src + '/**'
        ]
    });
    
});