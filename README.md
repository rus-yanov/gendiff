<h1><b> Gendiff </b></h1>
<p> Console based app,compares two JSON/YAML files and shows the differences between the objects. Output can be in 3 formats: stylish (default), json and pain.</p>

### Hexlet tests and linter status:
[![Actions Status](https://github.com/rus-yanov/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/rus-yanov/java-project-71/actions)
[![gendiff-check](https://github.com/rus-yanov/java-project-71/actions/workflows/gendiff-check.yml/badge.svg?branch=main)](https://github.com/rus-yanov/java-project-71/actions/workflows/gendiff-check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/db06c685490d05b7b1dd/maintainability)](https://codeclimate.com/github/rus-yanov/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/db06c685490d05b7b1dd/test_coverage)](https://codeclimate.com/github/rus-yanov/java-project-71/test_coverage)

<h3><b> Use cases:</b></h3> 
<ul>
  
  <li>Default (stylish) format output</li>
  
[![asciicast](https://asciinema.org/a/2S65kzC8hHKeAYWLts40Wtcnt.svg)](https://asciinema.org/a/2S65kzC8hHKeAYWLts40Wtcnt)

  <li>Plain format output</li> 
  
[![asciicast](https://asciinema.org/a/luhB2ApMyaTT653Ml2ip6ptCc.svg)](https://asciinema.org/a/luhB2ApMyaTT653Ml2ip6ptCc)
  
  <li>JSON format output</li>  
  
[![asciicast](https://asciinema.org/a/vkeRajjIQ7Y9k5fgtR2U787lY.svg)](https://asciinema.org/a/vkeRajjIQ7Y9k5fgtR2U787lY)
  
  <li>Help run</li>  
  
  [![asciicast](https://asciinema.org/a/gt7hCQTwBstiuhse4d1sBDsg6.svg)](https://asciinema.org/a/gt7hCQTwBstiuhse4d1sBDsg6)

</ul>


## Setup
```sh
make build
```

## Run
```sh
make run
```

## Run tests
```sh
make test
```

## Run checkstyle
```sh
make lint
```

## Check update dependencies and plugins
```sh
make update
```

